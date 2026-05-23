// Example: list cluster nodes.
//
// Run with:
//
//   PDM_HOST=https://pdm.example.com:8443 \
//   PDM_TOKEN='PDMAPIToken=root@pam!auto=...' \
//   ./gradlew run -PmainClass=examples.ListNodesKt
//
// Or compile + run with kotlin CLI directly.
package examples

import com.clientapi.pdm.Pve
import com.clientapi.pdm.infrastructure.ApiClient

fun main() {
    val host = System.getenv("PDM_HOST") ?: "https://localhost:8443"
    ApiClient.apiKey["Authorization"] = System.getenv("PDM_TOKEN") ?: ""

    val pdm = Pve(basePath = "$host/api2/json")
    val response = pdm.nodes().nodesGetNodes()
    val nodes = response.data ?: emptyList()
    println("Found ${nodes.size} node(s):")
    for (n in nodes) {
        println("  - ${n.node} (status=${n.status}, cpu=${n.cpu}, mem=${n.mem}/${n.maxmem})")
    }
}
