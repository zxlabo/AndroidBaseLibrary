package com.demo.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
@Database(entities = arrayOf(User::class), version = 2)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
//    abstract fun babyDao(): BabyDao

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
       //数据库打开的回调
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
//                var babyDao=    database.babyDao()
//                    babyDao.insertUser(Baby(1,"aaa",15))
                    var wordDao = database.userDao()

                    // Delete all content here.
                    wordDao.deleteAll()

                    // Add sample words.
                    var word = User("Hello")
                    wordDao.insertUser(word)
                    word = User("World!")
                    wordDao.insertUser(word)

                    word = User("TODO!")
                    wordDao.insertUser(word)
                }
            }
        }
    }
//     final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            // 因为没有变化，所以是一个空实现
//        }
//    };

    companion object {
        const val TABLE_NAME="word_database"
        @Volatile
        private var INSTANCE: UserDatabase? = null

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE userDataBase ADD COLUMN age INTEGER ")
            }
        }
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): UserDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    TABLE_NAME
                )
                    .addCallback(UserDatabaseCallback(scope))
                    .addMigrations(object :Migration(1,2){
                        override fun migrate(database: SupportSQLiteDatabase) {
                            database.execSQL("ALTER TABLE userDataBase ADD COLUMN age INTEGER NOT NULL DEFAULT 1")
                        }

                    })
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

