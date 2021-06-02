// https://github.com/MarkCLewis/SwiftVis2
// https://github.com/MarkCLewis/SwiftVis2/blob/master/examples/examples.md
package example

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import swiftvis2.plotting._
import swiftvis2.plotting.renderer.SwingRenderer

object First extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

  // Start spark
  val spark = SparkSession.builder()
    .master("local[*]")
    .appName("Spark with SwiftVis2")
    .getOrCreate()
  spark.sparkContext.setLogLevel("WARN")

  val xPnt = 1 to 10
  val yPnt = xPnt.map(a => a * a)

  val plot = Plot.scatterPlot(xPnt, yPnt, "Quadratic", "x", "y")
  SwingRenderer(plot, 300, 300, true)

  val plot2 = Plot.scatterPlot((1 to 1000).map(_ => math.random * math.random),
    (1 to 1000).map(_ => math.random * math.random), "Random Points", "x", "y")
  SwingRenderer(plot2, 500, 400, true)

  spark.stop()
}