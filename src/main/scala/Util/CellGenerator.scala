package Util

import Structure.Cells.Cell

/**
 * Created by ztidwell on 4/17/2015.
 */
trait CellGenerator[U <: Cell[U]] {

  def generate: Vector[U]


}
