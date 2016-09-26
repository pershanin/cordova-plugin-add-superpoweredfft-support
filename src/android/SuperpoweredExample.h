#ifndef Header_SuperpoweredExample
#define Header_SuperpoweredExample

#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>
#include <math.h>
#include <pthread.h>

#include "SuperpoweredExample.h"
#include "SuperpoweredFFT.h"

#define HEADROOM_DECIBEL 3.0f
static const float headroom = powf(10.0f, -HEADROOM_DECIBEL * 0.025);

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