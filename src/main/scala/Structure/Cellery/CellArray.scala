package Structure.Cellery

import Structure.Cells.Cell

trait CellArray {

  val cells: Vector[_]

  /**
   * Get the cell at the specified coordinates
   * @param coord
   * @return
   */
  def getCell(coord: Int*): Cell

}
