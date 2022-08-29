package uz.exemple.less8_task2_kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.exemple.less8_task2_kotlin.R
import uz.exemple.less8_task2_kotlin.model.UserModel

class SecondFragment:Fragment() {

    var listener: SecondListener? = null
    var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.second_fragment, container, false)
        initViews(view)
        return view
    }

    fun initViews(view: View) {
        textView = view.findViewById(R.id.tv_second_frag)
        val btn_second = view.findViewById<Button>(R.id.btn_second_frag)
        val user = UserModel("Abdul", "xyz@tuw.com", "961234578")
        btn_second.setOnClickListener {
            listener!!.sendSecond(user)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SecondListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

   public fun updateSecondText(user: UserModel) {
        textView!!.setText(user.toString())
    }

    public interface SecondListener {
        fun sendSecond(user: UserModel)
    }
}