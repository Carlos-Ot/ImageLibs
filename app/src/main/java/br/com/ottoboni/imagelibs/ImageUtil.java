package br.com.ottoboni.imagelibs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageUtil {

    private static String[] beaches = {"http://anyhdwallpaper.com/wp-content/uploads/2016/05/Sea-Beach-of-Thailand-HD-Wallpaper-Free-Download.jpg",
        "http://wallpapercave.com/wp/Ev1KCRT.jpg",
        "http://www.hdnicewallpapers.com/Walls/Big/Beach/Beautiful_Beach_Trees_HD_Wallpaper.jpg",
        "https://s-media-cache-ak0.pinimg.com/originals/02/83/25/028325fffc94e17c580d0b2f43a84e9d.jpg",
        "http://wallpapercave.com/wp/VAJYffn.jpg",
        "https://newevolutiondesigns.com/images/freebies/tropical-beach-background-22.jpg",
        "https://newevolutiondesigns.com/images/freebies/tropical-beach-background-16.jpg",
        "https://s-media-cache-ak0.pinimg.com/originals/a1/6e/48/a16e4838662f8742298b1d2fd6f057c7.jpg",
        "https://s-media-cache-ak0.pinimg.com/originals/69/1f/0d/691f0d0fed7f0f61f030366b9de8d1ed.jpg",
        "http://wallpapercave.com/wp/Vka8SnR.jpg"};

    private static String[] dogs = {"https://s-media-cache-ak0.pinimg.com/originals/29/96/3e/29963e0f73178f32a548481ac250e4c8.jpg",
        "https://www.chelseadogs.com/blog/wp-content/uploads/2013/07/Golden-Retriever-smartest-dog-breeds.jpg",
        "https://images6.alphacoders.com/431/thumb-1920-431153.jpg",
        "https://images.alphacoders.com/471/thumb-1920-471212.jpg",
        "http://greywolf-graphics.com/images/dogs-wallpaper/dogs-wallpaper-3.jpg",
        "https://images6.alphacoders.com/323/thumb-1920-323454.jpg",
        "https://www.passpawt.com/wp-content/uploads/2017/03/Original-image-1920x1200.jpeg",
        "http://s1.1zoom.me/b5050/624/Dogs_Closeup_Beagle_Snout_Glance_Head_514003_1920x1200.jpg",
        "http://img.animal-photos.ru/dogs/beagle/beagle24.jpg",
        "https://images7.alphacoders.com/436/thumb-1920-436264.jpg"};

    private static String[] forest = {"http://images6.fanpop.com/image/photos/37700000/magic-forest-beautiful-landscapes-37729163-1920-1200.jpg",
        "http://www.tokkoro.com/picsup/1136603-forest.jpg",
        "http://wallpapercave.com/wp/LiSEiMS.jpg",
        "https://s-media-cache-ak0.pinimg.com/originals/f3/56/d0/f356d001c8051635cd16305de4ec5757.jpg",
        "https://s-media-cache-ak0.pinimg.com/originals/c6/b4/03/c6b40385590f84bfb8680f79d54e5bf5.jpg",
        "http://miriadna.com/desctopwalls/images/max/In-the-forest.jpg",
        "http://miriadna.com/desctopwalls/images/max/Fairy-forest.jpg",
        "http://jonvilma.com/images/forest-18.jpg",
        "http://wallpapercave.com/wp/5XXnXos.jpg",
        "http://hdqwalls.com/wallpapers/forest-path.jpg"};

    public static List<String> getImageList(ListType listType) {
        List<String> list = new ArrayList<>();

        switch (listType) {
            case BEACHES:
                Collections.addAll(list, beaches);
                break;
            case DOGS:
                Collections.addAll(list, dogs);
                break;
            case FOREST:
                Collections.addAll(list, forest);
                break;
        }

        return list;
    }

    public enum ListType {
        BEACHES,
        DOGS,
        FOREST
    }
}
