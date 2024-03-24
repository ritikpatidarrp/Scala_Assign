case class PlayerStats(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int)

object PlayerStatistics {
  def main(args: Array[String]): Unit = {
    // Sample player statistics data
    val playerStatsData = List(
      PlayerStats(2021, "Sam", "India", 23, 2300, 3),
      PlayerStats(2021, "Ram", "India", 23, 300, 30),
      PlayerStats(2021, "Mano", "India", 23, 300, 13)
    )

    // Find player with the highest run scored
    val playerWithHighestRuns = playerStatsData.maxBy(_.runs)
    println(s"Player with the highest run scored: ${playerWithHighestRuns.playerName}")

    // Top 5 players by run scored
    val topPlayersByRuns = playerStatsData.sortBy(_.runs)(Ordering[Int].reverse).take(5)
    println("\nTop 5 players by run scored:")
    topPlayersByRuns.foreach(player => println(s"${player.playerName}: ${player.runs} runs"))

    // Top 5 players by wicket taken
    val topPlayersByWickets = playerStatsData.sortBy(_.wickets)(Ordering[Int].reverse).take(5)
    println("\nTop 5 players by wickets taken:")
    topPlayersByWickets.foreach(player => println(s"${player.playerName}: ${player.wickets} wickets"))

    // Rank players with overall performance
    val rankedPlayers = playerStatsData.map { player =>
      val overallPerformance = player.wickets * 5 + player.runs * 0.05
      (player.playerName, overallPerformance)
    }.sortBy(_._2)(Ordering[Double].reverse)

    println("\nRanked players with overall performance:")
    rankedPlayers.zipWithIndex.foreach { case ((playerName, performance), rank) =>
      println(s"Rank ${rank + 1}: $playerName - Overall Performance: $performance")
    }
  }
}
