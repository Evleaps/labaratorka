package environment.framework.sound;

/*************************************************
 * Author: Novikov Artem
 * Date: 31.03.2018
 * Module name: Sound
 * Desciprion: Class implements ISound functional
 *************************************************/

public class Sound implements ISound {

    @Override
    public void play(int id) {

    }
    /*private static final String SOUND_MSG_IN_FILENAME = "sounds/msg_in.mp3";

    public static int MSG_IN;
    private static final String LOG = "Sound LOG";
    private SoundPool mPool;

    public Sound(int maxStreams, AssetManager assetManager) {
        mPool = new SoundPool(maxStreams, AudioManager.STREAM_NOTIFICATION,0);
        mPool.setOnLoadCompleteListener(mListener);
        MSG_IN = -1;
        MSG_IN = load(assetManager, SOUND_MSG_IN_FILENAME);
    }

    @Override
    public void play(int id) {
        if(id != -1) {
            mPool.play(id, 1, 1, 1, 0, 1);
        } else {
            Env.log(LOG, "Sound with id = " + id + " not loaded at the moment");
        }
    }

    private int load(AssetManager manager, String name) {
        int res = -1;
        try {
            res = mPool.load(manager.openFd(name),1);
        } catch (IOException e) {
            Env.log(LOG, "Error while load file: " + name);
            e.printStackTrace();
        }
        return  res;
    }

    private SoundPool.OnLoadCompleteListener mListener = new SoundPool.OnLoadCompleteListener() {
        @Override
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            Env.log(LOG, "Load of sound complete (id=" + sampleId + ").");
        }
    };*/
}
