package o1310.rx1310.aoslp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Central list of files the Launcher writes to the application data directory.
 *
 * To add a new Launcher file, create a String constant referring to the filename, and add it to
 * ALL_FILES, as shown below.
 */
public class LauncherFiles {

    private static final String XML = ".xml";

    public static final String DEFAULT_WALLPAPER_THUMBNAIL = "default_thumb2.jpg";
    public static final String DEFAULT_WALLPAPER_THUMBNAIL_OLD = "default_thumb.jpg";
    public static final String LAUNCHER_DB = "launcher.db";
    public static final String SHARED_PREFERENCES_KEY = "o1310.rx1310.aoslp.prefs";
    public static final String WALLPAPER_CROP_PREFERENCES_KEY =
            "o1310.rx1310.aoslp.WallpaperCropActivity";
    public static final String MANAGED_USER_PREFERENCES_KEY = "o1310.rx1310.aoslp.managedusers.prefs";

    public static final String WALLPAPER_IMAGES_DB = "saved_wallpaper_images.db";
    public static final String WIDGET_PREVIEWS_DB = "widgetpreviews.db";
    public static final String APP_ICONS_DB = "app_icons.db";

    public static final List<String> ALL_FILES = Collections.unmodifiableList(Arrays.asList(
            DEFAULT_WALLPAPER_THUMBNAIL,
            DEFAULT_WALLPAPER_THUMBNAIL_OLD,
            LAUNCHER_DB,
            SHARED_PREFERENCES_KEY + XML,
            WALLPAPER_CROP_PREFERENCES_KEY + XML,
            WALLPAPER_IMAGES_DB,
            WIDGET_PREVIEWS_DB,
            MANAGED_USER_PREFERENCES_KEY,
            APP_ICONS_DB));

    // TODO: Delete these files on upgrade
    public static final List<String> OBSOLETE_FILES = Collections.unmodifiableList(Arrays.asList(
            "launches.log",
            "stats.log",
            "launcher.preferences",
            "o1310.rx1310.aoslp.compat.PackageInstallerCompatV16.queue"));
}
