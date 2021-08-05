package com.demo.activity.other

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.base.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * author : Naruto
 * date   : 3/3/21
 * desc   :
 * version:
 */
class RegionSelectPicker {

    private var mJsonObj: JSONObject? = null
    private var popwindow: PopupWindow? = null
    private var popview: View? = null


    private var mProvinceDatas: Array<String?>? = null   //所有省
    private val mCitisDatasMap = hashMapOf<String, Array<String?>>() //key - 省 value - 市
    private val mAreaDatasMap = hashMapOf<String, Array<String?>>() //key - 市 value - 区

    /**
     * 解析整个Json对象，完成后释放Json对象的内存
     */
    fun initAddressData(regionsJson: JSONObject) {
        try {
            mJsonObj = regionsJson.optJSONObject("data")
            val jsonArray = mJsonObj!!.getJSONArray("provinces")
            mProvinceDatas = arrayOfNulls(jsonArray.length())
            for (i in 0 until jsonArray.length()) {
                val jsonP = jsonArray.getJSONObject(i) // 每个省的json对象
                val province = jsonP.getString("name") // 省名字
                mProvinceDatas!![i] = province
                var jsonCs: JSONArray
                jsonCs = try {
                    jsonP.getJSONArray("cities")
                } catch (e1: Exception) {
                    continue
                }
                val mCitiesDatas =
                    arrayOfNulls<String>(jsonCs.length())
                for (j in 0 until jsonCs.length()) {
                    val jsonCity = jsonCs.getJSONObject(j)
                    val city = jsonCity.getString("name") // 市名字
                    mCitiesDatas[j] = city
                    var jsonAreas: JSONArray
                    jsonAreas = try {
                        jsonCity.getJSONArray("districts")
                    } catch (e: Exception) {
                        continue
                    }
                    val mAreasDatas =
                        arrayOfNulls<String>(jsonAreas.length()) // 当前市的所有区
                    for (k in 0 until jsonAreas.length()) {
                        val area =
                            jsonAreas.getJSONObject(k).getString("name") // 区域的名称
                        mAreasDatas[k] = area
                    }
                    mAreaDatasMap[city] = mAreasDatas
                }
                mCitisDatasMap[province] = mCitiesDatas
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        mJsonObj = null
    }

    fun showAddressPicker(context: Context) {
        initPopUpWindow(context)
        if (!isShow()){
            popwindow?.showAtLocation(popview, Gravity.BOTTOM, 0, 0);
        }
    }

    private fun initPopUpWindow(context: Context) {
        popview = LayoutInflater.from(context).inflate(R.layout.layout_address_select_picker, null)
        popwindow = PopupWindow(
            popview,
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        //        popwindow?.animationStyle = R.style.AnimBottom
        popwindow?.setBackgroundDrawable(ColorDrawable())
        popwindow?.isTouchable = true
        popwindow?.isOutsideTouchable = false
        popwindow?.isFocusable = true

    }

    private fun isShow(): Boolean {
        return popwindow?.isShowing ?: false
    }
}