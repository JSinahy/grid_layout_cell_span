package com.jsle.testgridlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jsle.testgridlayout.databinding.FragmentCompleteTheLookPageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CompleteTheLookPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompleteTheLookPageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCompleteTheLookPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCompleteTheLookPageBinding.inflate(layoutInflater, container, false)
        addCustomView(binding.gridLayout)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CompleteTheLookPageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CompleteTheLookPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun addCustomView(root: ViewGroup) {
        val gridLayout = root.findViewById<androidx.gridlayout.widget.GridLayout>(R.id.gridLayout)

        val arr = intArrayOf(10, 11, 12, 13, 14)
        var products = arrayOf("Sabritas","Pan bimbo","Mandarina","Plata Roatan","Mango Ataulfo")
        var r = 0
        for (i in 0..arr.size - 1) {

            val itemView = LayoutInflater.from(activity).inflate(R.layout.item_grid_layout, null, false)
            val image = itemView.findViewById<ImageView>(R.id.imageGridLayout)
            image.setBackgroundResource(R.drawable.perrito)

            val textTitle = itemView.findViewById<TextView>(R.id.textGridLayout)
            textTitle.text = "${products[i]}"

            val textPrice = itemView.findViewById<TextView>(R.id.priceGridLayout)
            textPrice.text = "$ ${arr[i]}.00"

            var rowSpan: GridLayout.Spec? = GridLayout.spec(
                GridLayout.UNDEFINED, 1,1f)
            var colSpan: GridLayout.Spec? = GridLayout.spec(
                GridLayout.UNDEFINED, 1,1f)

            if (r == 0) {
                //itemView.layoutParams = LinearLayout.LayoutParams(getScaleDp(164), getScaleDp(300))
                //image.layoutParams = LinearLayout.LayoutParams(getScaleDp(164), getScaleDp(300))
                colSpan = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
                rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 2, 1f);
            }
            val gridParam: GridLayout.LayoutParams = GridLayout.LayoutParams(
                rowSpan, colSpan
            )
            gridLayout.addView(itemView, gridParam)
            r++
        }
    }
    fun getScaleDp(dp: Int): Int = (dp * resources.displayMetrics.density - 20f).toInt()
}