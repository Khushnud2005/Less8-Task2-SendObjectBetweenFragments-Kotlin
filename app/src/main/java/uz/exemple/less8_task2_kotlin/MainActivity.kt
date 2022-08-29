package uz.exemple.less8_task2_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.exemple.less8_task2_kotlin.fragment.FirstFragment
import uz.exemple.less8_task2_kotlin.fragment.SecondFragment
import uz.exemple.less8_task2_kotlin.model.UserModel

class MainActivity : AppCompatActivity(),FirstFragment.FirstListener,SecondFragment.SecondListener {
    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.firstFrame, firstFragment)
            .replace(R.id.secondFrame, secondFragment)
            .commit()
    }

    override fun sendFirst(user: UserModel) {
        secondFragment.updateSecondText(user)
    }

    override fun sendSecond(user: UserModel) {
        firstFragment.updateFirstText(user)
    }


}