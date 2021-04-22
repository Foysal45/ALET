package com.alet.apps.c_activity.ac_details.fragment.fg_faq.model

class FAQ(
    private var question: String?,
    private var answer: String?,
) {
    fun getQuestion(): String {
        if (question.equals(null))
            return ""
        return question!!
    }

    fun getAnswer(): String {
        if (answer.equals(null))
            return ""
        return answer!!
    }
}