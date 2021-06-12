package com.example.gifparsing

import android.os.Bundle

interface OnChangeFragmentListener {
    fun onFragmentChange(fragmentConstant: Int, bundle: Bundle?)
}