package com.example.nightendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        // Agregar un listener para detectar cambios de página
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // No se necesita implementar aquí
            }

            override fun onPageSelected(position: Int) {
                // Cambiar a MapFragment cuando se desliza a la izquierda desde MainFragment
                if (position == 1) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.viewPager, MapFragment())
                        .commit()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                // No se necesita implementar aquí
            }
        })
    }

    private inner class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int {
            return 2 // Número total de fragmentos
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> MainFragment() // Fragmento para activity_main
                1 -> MapFragment() // Fragmento para activity_map
                else -> MainFragment()
            }
        }
    }
}
