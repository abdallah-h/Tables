package com.abdohfox.abdallah.schedules.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by abdoh on 2017-04-10.
 */

public final class SchContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private SchContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.abdohfox.abdallah.schedules";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_SCH = "sch";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */

    public static abstract class SchEntry implements BaseColumns {

        public static final String TABLE_NAME = "sche";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCH_VALUE = "name";
        public static final String COLUMN_SCH_FROM = "breed";
        public static final String COLUMN_SCH_TO = "tos";

        /** The content URI to access the pet data in the provider */
        /*
         inside each of the Entry classes in the contract,
         we create a full URI for the class as a constant called CONTENT_URI.
         The Uri.withAppendedPath() method appends the BASE_CONTENT_URI
         (which contains the scheme and the content authority) to the path segment.
        */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_SCH);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCH;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCH;





    }

}
