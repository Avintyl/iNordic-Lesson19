package com.example.lesson19.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lesson19.R

fun FragmentManager.navigateToFragment(fragment: Fragment) {
    this.beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .commit()
}