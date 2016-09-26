package org.pershanin.superpoweredfft;

public class SuperpoweredExample {
	public:

		SuperpoweredExample(const char *path, int *params);
		~SuperpoweredExample();

		void process(SLAndroidSimpleBufferQueueItf caller);
		void onPlayPause(bool play);
		void onCrossfader(int value);
		void onFxSelect(int value);
		void onFxOff();
		void onFxValue(int value);

	private:
		SuperpoweredFFT *fft;
};

#endif