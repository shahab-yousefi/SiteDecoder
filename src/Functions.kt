
// extract extension name of a file path string - example: folder/image.(png)
fun String.getFormat(): String {
    val index = lastIndexOf('.')
    return if(index < 0 || index+1 == length)
        ""
    else {
        substring(index+1, length)
    }
}

// convert persian number to english in string
fun String.enNum(): String {
    val s = toCharArray()
    s.forEachIndexed { index, c ->
        when(c) {
            '۱' -> s[index] = '1'
            '۲' -> s[index] = '2'
            '۳' -> s[index] = '3'
            '۴' -> s[index] = '4'
            '۵' -> s[index] = '5'
            '۶' -> s[index] = '6'
            '۷' -> s[index] = '7'
            '۸' -> s[index] = '8'
            '۹' -> s[index] = '9'
            '۰' -> s[index] = '0'
        }
    }
    return String(s)
}

// translate some persian word to english in string
fun String.fa2en(): String {
    var s = this

    s = s.replace("دانلود", "Download")
    s = s.replace("سرور", "server")
    s = s.replace("مستقیم", "direct")
    s = s.replace("فیلم های", "movies")
    s = s.replace("فیلم ها", "movies")
    s = s.replace("فیلم", "movie")
    s = s.replace("انیمیشن های", "animations")
    s = s.replace("انیمیشن ها", "animations")
    s = s.replace("انیمیشن", "animation")
    s = s.replace("دوبله", "dubbed")
    s = s.replace("فارسی", "persian")
    s = s.replace("مجموعه", "Collection")
    s = s.replace("کالکشن", "Collection")
    s = s.replace("از", "from")
    s = s.replace("سریال های", "series")
    s = s.replace("سریال ها", "series")
    s = s.replace("سریال", "series")
    s = s.replace("نسخه", "version")
    s = s.replace("لینک", "link")
    s = s.replace("لینک", "link")
    s = s.replace("تریلر", "trailer")

    return s
}

// remove all persian character from string
fun String.rmFa(): String {
    val s = toCharArray()
    val b = StringBuilder()

    s.forEach {
        if(it.toInt() !in 1570..1740) {
            b.append(it)
        }
    }

    return b.toString().trim().replace(Regex("\\s+"), " ")
}


// extract name of file from a file path string - example: folder/(image).png
fun String.getFileName(): String {
    val index = lastIndexOf('/')
    return if(index < 0)
        ""
    else {
        substring(index+1, length).replace(getFormat(), "").trim('.')
    }
}