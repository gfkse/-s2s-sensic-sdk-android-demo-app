package com.gfk.s2s.demo.video.exoPlayer.extension

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.gfk.s2s.demo.MainActivity
import com.gfk.s2s.demo.s2s.R
import com.gfk.s2s.demo.video.exoPlayer.BaseVideoFragment
import com.gfk.s2s.exoplayer.ExoplayerExtension
import com.gfk.s2s.s2sagent.S2SConfig

class VODExtensionFragment : BaseVideoFragment() {

    override val videoURL = "https://demo-config-preproduction.sensic.net/video/video3.mp4"
    private val configUrl = "https://demo-config-preproduction.sensic.net/s2s-android.json"
    private val mediaId = "s2s-exoplayer-android-demo"
    private val contentIdDefault = "default"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? MainActivity)?.supportActionBar?.title =
            getString(R.string.fragment_title_vod)
        return inflater.inflate(R.layout.video_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.prepareVideoPlayer()

        val config = S2SConfig(
            mediaId,
            configUrl,
            true,
            null
        )

        ExoplayerExtension(
            exoPlayer!!,
            config,
            contentIdDefault,
            hashMapOf(),
            requireContext(),
            this,
        )
    }
}