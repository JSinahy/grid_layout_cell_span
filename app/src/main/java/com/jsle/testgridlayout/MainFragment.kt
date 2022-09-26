package com.jsle.testgridlayout

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jsle.testgridlayout.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)


        val pageAdapter = ScreenSlidePagerAdapter(this)
        val nextItemVisiblePx = 150
        val currentItemHorizontalMarginPx = 150
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->

                //page.translationX = -nextItemVisiblePx * position


        }
        binding.viewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 1
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when(position){
                        0 -> {
                            //setMargins(0, 0, offsetPx, 0)
                        }
                        2 -> {
                            //setMargins(offsetPx, 0, 0, 0)
                        }
                        else -> {
                            //setMargins(offsetPx, 0, offsetPx, 0)
                        }
                    }
                }
            })
        }


        binding.viewPager.setPageTransformer(pageTransformer)
        binding.viewPager.adapter = pageAdapter
        binding.viewPager.addItemDecoration(HorizontalMarginItemDecoration(this))

        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        { tab, position -> }.attach()

        return binding.root
    }

    class HorizontalMarginItemDecoration(context: Fragment) :
        RecyclerView.ItemDecoration() {

        private val horizontalMarginInPx: Int = context.resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin).toInt()

        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
        ) {
            outRect.right = horizontalMarginInPx
            outRect.left = horizontalMarginInPx
        }

    }

    open class ScreenSlidePagerAdapter(fm: Fragment): FragmentStateAdapter(fm){
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            val fragment = CompleteTheLookPageFragment()
            return fragment
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                MainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }


}