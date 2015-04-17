import Structure.Cells.Cell

/**
 * Created by ztidwell on 4/17/2015.
 */
trait Automaton[CellArray] {

  val cellery: CellArray

  def unit[U](x: U): Automaton[U]

  def flatMap[U](f: CellArray => Automaton[U]): Automaton[U]

}
