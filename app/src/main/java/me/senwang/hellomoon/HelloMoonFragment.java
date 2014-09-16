package me.senwang.hellomoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment{

	private AudioPlayer mPlayer = new AudioPlayer();

	private Button mPlayButton;
	private Button mStopButton;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

		mPlayButton = (Button) v.findViewById(R.id.play_button);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
			}
		});

		mStopButton = (Button) v.findViewById(R.id.stop_button);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlayer.stop();
			}
		});

		return v;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
}
