package com.connect.svecw;

import android.provider.BaseColumns;

/**

 */
public class StudentContract {

    public static final class StudentEntry implements BaseColumns {

        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME = "student_name";
        public static final String COLUMN_EMAIL = "student_email";
        public static final String COLUMN_BRANCH = "student_branch";
        public static final String COLUMN_CLUB = "student_club";
        public static final String COLUMN_CONTACT = "student_contact";
    }
}
