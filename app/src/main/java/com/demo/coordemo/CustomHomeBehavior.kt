//package com.demo.CoordinatorLayoutDemo
//
//import android.content.Context
//import android.util.AttributeSet
//import android.view.View
//import androidx.coordinatorlayout.widget.CoordinatorLayout
//import androidx.core.view.ViewCompat
//import androidx.core.widget.NestedScrollView
//import com.base.R
//
//class CustomHomeBehavior : CoordinatorLayout.Behavior<View> {
//    constructor()
//    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
//
//    override fun onStartNestedScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: View,
//        directTargetChild: View,
//        target: View,
//        axes: Int,
//        type: Int
//    ): Boolean {
//        return axes and ViewCompat.SCROLL_AXIS_VERTICAL != 0
//    }
//
//    var childView: View? = null
//    var location = 0f
//
//    override fun onNestedPreScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: View,
//        target: View,
//        dx: Int,
//        dy: Int,
//        consumed: IntArray,
//        type: Int
//    ) {
//        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
//        if (target is NestedScrollView) {
//            (childView ?: target.findViewById<View>(R.id.layout_ad).apply { childView = this })
//                ?: return
//            location = childView!!.y - child.height - 20
//            if (target.scrollY >= location && child.translationY != -child.height.toFloat() && dy > 0) {
//                var finalY = child.translationY - dy
//                if (finalY < -child.height) {
//                    finalY = -child.height.toFloat()
//                } else if (finalY > 0) {
//                    finalY = 0f
//                }
//                child.translationY = finalY
//                return
//            }
//
//            if (target.scrollY <= location - child.translationY && child.translationY != 0f && dy < 0) {
//                var finalY = child.translationY - dy
//                if (finalY < -child.height) {
//                    finalY = -child.height.toFloat()
//                } else if (finalY > 0) {
//                    finalY = 0f
//                }
//                child.translationY = finalY
//            }
//        }
//    }
//}