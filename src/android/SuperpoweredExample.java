package org.pershanin.superpoweredfft;

public class SuperpoweredExample {
	public	SuperpoweredExample(const char *path, int *params);
	public	~SuperpoweredExample();

	public	void process(SLAndroidSimpleBufferQueueItf caller);
	public	void onPlayPause(bool play);
	public	void onCrossfader(int value);
	public	void onFxSelect(int value);
	public	void onFxOff();
	public	void onFxValue(int value);

	private SuperpoweredFFT *fft;
};

#endif