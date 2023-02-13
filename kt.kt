// Define a data class to represent a subset
data class Subset(val set: MutableList<Int>)

// Function to generate all possible subsets of a given set
fun generateSubsets(set: List<Int>): List<Subset> {
    val subsets = mutableListOf<Subset>()
    val n = set.size
    val binary = IntArray(n) { 0 }

    // Generate all binary combinations
    for (i in 0 until 1.shl(n)) {
        for (j in 0 until n) {
            if (i and (1.shl(j)) != 0) {
                binary[j] = 1
            } else {
                binary[j] = 0
            }
        }

        // Generate the subset based on the binary combination
        val subset = mutableListOf<Int>()
        for (j in 0 until n) {
            if (binary[j] == 1) {
                subset.add(set[j])
            }
        }
        subsets.add(Subset(subset))
    }

    return subsets
}

// Example usage
fun main() {
    val set = listOf(1, 2, 3)
    val subsets = generateSubsets(set)
    for (subset in subsets) {
        println(subset.set)
    }
}
