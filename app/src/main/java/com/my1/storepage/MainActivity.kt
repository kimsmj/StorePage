package com.my1.storepage

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.my1.storepage.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        //매장 페이지(하단 네비게이션뷰 말고) 데이터는 라이브데이터를 쓸 필요가 없기 때문에
        //매장 사진, 이름, 키워드, 위치 등은
        //binding."이미지뷰Id".setImageResource(...)
        //binding."텍스트뷰Id".setText("...")
        //이런식으로 간단히 받아오면 됨
        //뷰바인딩을 쓰고 있기 때문에 findById 사용 불가능!!

        //--------
        //매장 찜(하트 클릭) 이벤트
        //상수 하나 두고 조건문 추가해서 빈하트/하트 여부 핸들하면 될 듯함

        var isLiked = 0
        //~DB에서 찜여부 받아오기~

        binding.like.setOnClickListener(View.OnClickListener {
            if(isLiked==1){
                binding.like.setImageResource(R.drawable.h1)
                isLiked = 0
                Toast.makeText(
                    this@MainActivity,
                    "찜한 매장에서 삭제되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()
                //~DB에 찜여부 갱신~
            }
            else {
                binding.like.setImageResource(R.drawable.h2)
                isLiked = 1
                Toast.makeText(
                    this@MainActivity,
                    "찜한 매장에 추가되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()
                //~DB에 찜여부 갱신~
            }
        })

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }


}