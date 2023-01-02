package generating.builder


internal class Headphone(
    private val type: String,
    private val loudspeakerType: String,
    private val bodyType: String,
    private val wireType: String
) {
    override fun toString(): String {
        return ("Headphone [type=" + type + ", loudspeakerType=" + loudspeakerType + ", bodyType=" + bodyType
                + ", wireType=" + wireType + "]")
    }
}

internal interface HeadphoneParts {
    fun setType(): HeadphoneParts
    fun setLoudspeaker(loudspeakerType: String): HeadphoneParts
    fun setBody(bodyType: String): HeadphoneParts
    fun setWire(wireType: String): HeadphoneParts
    fun build(): Headphone
}

internal class HiFiHeadphoneParts : HeadphoneParts {
    private lateinit var type: String
    private lateinit var loudspeakerType: String
    private lateinit var bodyType: String
    private lateinit var wireType: String
    override fun setType(): HeadphoneParts {
        type = "Hi-Fi"
        return this
    }

    override fun setLoudspeaker(loudspeakerType: String): HeadphoneParts {
        this.loudspeakerType = loudspeakerType
        return this
    }

    override fun setBody(bodyType: String): HeadphoneParts {
        this.bodyType = bodyType
        return this
    }

    override fun setWire(wireType: String): HeadphoneParts {
        this.wireType = wireType
        return this
    }

    override fun build(): Headphone {
        return Headphone(type, loudspeakerType, bodyType, wireType)
    }
}

internal class HiEndHeadphoneParts : HeadphoneParts {
    private lateinit var type: String
    private lateinit var loudspeakerType: String
    private lateinit var bodyType: String
    private lateinit var wireType: String
    override fun setType(): HeadphoneParts {
        type = "Hi-End"
        return this
    }

    override fun setLoudspeaker(loudspeakerType: String): HeadphoneParts {
        this.loudspeakerType = loudspeakerType
        return this
    }

    override fun setBody(bodyType: String): HeadphoneParts {
        this.bodyType = bodyType
        return this
    }

    override fun setWire(wireType: String): HeadphoneParts {
        this.wireType = wireType
        return this
    }

    override fun build(): Headphone {
        return Headphone(type, loudspeakerType, bodyType, wireType)
    }
}

internal class Engineer(private val headphoneParts: HeadphoneParts) {
    fun buildHeadphone(): Headphone? {
        return if (headphoneParts is HiFiHeadphoneParts) {
            headphoneParts
                .setType()
                .setLoudspeaker("First class")
                .setBody("First class")
                .setWire("First class")
                .build()
        } else if (headphoneParts is HiEndHeadphoneParts) {
            headphoneParts
                .setType()
                .setLoudspeaker("Premium class")
                .setBody("Premium class")
                .setWire("Premium class")
                .build()
        } else {
            null
        }
    }
}

fun main(args: Array<String>) {
    val engineer1 = Engineer(HiFiHeadphoneParts())
    val hifi = engineer1.buildHeadphone()
    println(hifi)
    val engineer2 = Engineer(HiEndHeadphoneParts())
    val hiend = engineer2.buildHeadphone()
    println(hiend)
}
