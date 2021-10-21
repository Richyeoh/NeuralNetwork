val input = arrayListOf(
    1, 1, 1,
    1, 1, 1,
    1, 1, 1,
    1, 1, 1
)

val feature1 = arrayListOf(3, 6)

val feature2 = arrayListOf(4, 7)

val feature3 = arrayListOf(5, 8)

val output0 = arrayListOf(0, 2)

val output1 = arrayListOf(1)

fun ArrayList<Int>.matchers(vararg features: ArrayList<Int>): ArrayList<Int> {
    val predicted = ArrayList<Int>()
    features.forEach { feature ->
        val activated = feature.all { index ->
            val match = (this[index] and 1)
            val activated = (match == 1)
            println("index:$index,match=$match,activated=$activated")
            activated
        }
        if (activated) {
            predicted.add(1)
        } else {
            predicted.add(0)
        }
    }
    return predicted
}

fun main() {
    val features = input.matchers(feature1, feature2, feature3)
    val outputs = features.matchers(output0, output1)
    if (outputs[0] > outputs[1]) {
        println("输入的图像可能是0")
    } else {
        println("输入的图像可能是1")
    }
}
