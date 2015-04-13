package Structure

trait CellArray {

  val dim : Int

  val cells: Vector[_]

  /**
   * Get the cell at the specified coordinates
   * @param pos
   * @return
   */
  def getCell(pos: Vector[Int]): Cell

}
