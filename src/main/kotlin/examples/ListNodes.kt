// Example: list cluster nodes.
//
// Run with:
//
//   PDM_HOST=https://pdm.example.com:8443 \
//   PDM_TOKEN='PDMAPIToken=root@pam!auto:...' \
//   ./gradlew run -PmainClass=examples.ListNodesKt
//
// Or compile + run with kotlin CLI directly.
package examples

import com.clientapi.pdm.apis.NodesApi
import com.clientapi.pdm.infrastructure.ApiClient

fun main() {
    val host = System.getenv("PDM_HOST") ?: "https://localhost:8443"
    ApiClient.apiKey["Authorization"] = System.getenv("PDM_TOKEN") ?: ""

    // Non-PVE products: the upstream apidoc declares this endpoint
    // `returns: { type: null }`, so `response.data` is untyped. Print
    // the whole response and let the user see what came back.
    val response = NodesApi(basePath = "$host/api2/json").nodesGetNodes()
    println("Response: $response")
}
