package com.jsle.testgridlayout


import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.view.marginRight
import androidx.core.view.marginTop


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun addCustomView(root: ViewGroup) {

        val metrics = resources.displayMetrics

        val gridLayout = findViewById<androidx.gridlayout.widget.GridLayout>(R.id.gridLayout)

        val arr = intArrayOf(3, 4, 3, 2, 5)
        var r = 0
        for (i in 0..arr.size - 1) {
            /*val cardView = createChild()
            //val imageView = ImageView(this)
            val imageView = ImageView(this)
            val textTitle = TextView(this)
            val textPrice = TextView(this)
            imageView.adjustViewBounds = false
            imageView.layoutParams = ViewGroup.LayoutParams(px.toInt(), py.toInt())

            textTitle.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            textTitle.text = "Sabritas Kellogs"

            textPrice.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            textPrice.text = "$ 10.00"

            var rowSpan: GridLayout.Spec = GridLayout.spec(GridLayout.UNDEFINED, 1,1f)
            var colSpan: GridLayout.Spec = GridLayout.spec(GridLayout.UNDEFINED, 1,1f)

            if (r == 0) {
                cardView.layoutParams = ViewGroup.LayoutParams(164, 300)
                imageView.layoutParams = ViewGroup.LayoutParams(px.toInt(), GridLayout.LayoutParams.MATCH_PARENT)
                colSpan = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
                rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 2, 1f);
            }

            val gridParam: GridLayout.LayoutParams = GridLayout.LayoutParams(
                rowSpan, colSpan
            )
            imageView.setBackgroundResource(R.drawable.perrito)
            imageView.scaleType = ImageView.ScaleType.CENTER
            cardView.addView(imageView)
            cardView.addView(textTitle)
            cardView.addView(textPrice)
            gridLayout.addView(cardView, gridParam)
            r++*/

            val itemView = LayoutInflater.from(this).inflate(R.layout.item_grid_layout, null, false)
            val image = itemView.findViewById<ImageView>(R.id.imageGridLayout)
            image.setBackgroundResource(R.drawable.perrito)

            val textTitle = itemView.findViewById<TextView>(R.id.textGridLayout)
            textTitle.text = "Sabritas Kellogs"

            val textPrice = itemView.findViewById<TextView>(R.id.priceGridLayout)
            textPrice.text = "$ ${arr[i]}.00"

            var rowSpan: androidx.gridlayout.widget.GridLayout.Spec? = androidx.gridlayout.widget.GridLayout.spec(GridLayout.UNDEFINED, 1,1f)
            var colSpan: androidx.gridlayout.widget.GridLayout.Spec? = androidx.gridlayout.widget.GridLayout.spec(GridLayout.UNDEFINED, 1,1f)
            if (r == 0) {
                itemView.layoutParams = LinearLayout.LayoutParams(getScaleDp(164), getScaleDp(300))
                image.layoutParams = LinearLayout.LayoutParams(getScaleDp(164), getScaleDp(300)).apply {
                    setMargins(0, 0, 0, 18)
                }
                colSpan = androidx.gridlayout.widget.GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
                rowSpan = androidx.gridlayout.widget.GridLayout.spec(GridLayout.UNDEFINED, 2, 1f);
            }
            val gridParam: androidx.gridlayout.widget.GridLayout.LayoutParams = androidx.gridlayout.widget.GridLayout.LayoutParams(
                rowSpan, colSpan
            )

            gridLayout.addView(itemView, gridParam)
            r++
        }
    }

    fun getScaleDp(dp: Int): Int = (dp * resources.displayMetrics.density - 30f).toInt()

    private fun createChild(): LinearLayout {
        val cardView = LinearLayout(this)
        cardView.orientation = LinearLayout.VERTICAL
        val cvLayoutParams = LinearLayout.LayoutParams(
            164,
            116
        )
        cvLayoutParams.setMargins(0, 30, 300, 30)
        cardView.layoutParams = cvLayoutParams
        return cardView
    }
}