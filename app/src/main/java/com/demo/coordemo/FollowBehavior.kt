package com.demo.coordemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * author : Naruto
 * date   : 2020-09-03
 * desc   : 泛型为观察者View，跟着别人动的那个view
 * Dependent View，可以理解为被观察者。
 * 我们这个例子中，button是Dependent View，textview跟随着button移动而移动。
 *
 * version:
 */
class FollowBehavior : CoordinatorLayout.Behavior<View> {
    constructor()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    /**
     * 判断child的布局是否依赖dependence
     * 在一个交互行为中，Dependent View 的变化决定了另一个相关 View 的行为。
     * 在这个例子中， Button 就是 Dependent View，因为 TextView 跟随着它。
     * 实际上 Dependent View 就相当于我们前面介绍的被观察者
     */
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is Button
    }


    /**
    *  当Dependent View发生变化时，这个方法会被调用。
     * child相当于本次的观察者。
     */
    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        child.x=dependency.x
        child.y=dependency.y+100
        return true
    }

}