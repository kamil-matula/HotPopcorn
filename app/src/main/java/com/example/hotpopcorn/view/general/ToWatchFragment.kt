package com.example.hotpopcorn.view.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ToWatchFragment : AbstractGeneralFragmentForLibrary() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initializeList(firebaseVM.matchingObjectsToWatch)
        return binding.root
    }
}