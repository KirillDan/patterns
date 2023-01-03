package structural.adapter

internal class OldService {
    fun requestOld(valueOld: String): String {
        return "result with old value = $valueOld"
    }
}

internal interface NewService {
    fun requestNew(valueNew: Int): String
}

internal class AdapterFromNewToOld(private val oldService: OldService) : NewService {
    override fun requestNew(valueNew: Int): String {
        return oldService.requestOld(convertValueFromNewToOld(valueNew))
    }

    private fun convertValueFromNewToOld(valueNew: Int): String {
        return valueNew.toString()
    }
}


fun main(args: Array<String>) {
    val oldService = OldService()
    val adapterFromNewToOld = AdapterFromNewToOld(oldService)
    val result = adapterFromNewToOld.requestNew(11)
    println(result)
}

