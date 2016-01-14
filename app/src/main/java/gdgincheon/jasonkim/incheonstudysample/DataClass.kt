package gdgincheon.jasonkim.incheonstudysample

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by kimjason on 16. 1. 15..
 */
public open class DataClass(

        @PrimaryKey
        public open var Title:String?="",
        public open var OriginalLink:String?="",
        public open var Description:String?="",
        public open var Pubdate:String?=""

):RealmObject(){}