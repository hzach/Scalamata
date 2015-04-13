package Structure.Cells

/**
 * TODO: Doc.
 */
trait Cell[U <: Cell[U]] { self =>
  /**
   *
   */
  val state: Byte

  /**
   *
   */
  val min: Byte = 0

  /**
   *
   */
  val max: Byte

  /**
   *
   * @return
   */
  def next: Cell[U] = {
    val m = this.max
    val s = this.state
    if (s < max)
      new Cell[U] {
        override val max: Byte = m
        override val state: Byte = (s + 1).toByte
      }
    else
      this
  }

  /**
   *
   * @return
   */
  def prev: Cell[U] = {
    val m = this.max
    val s = this.state
    if (s > min)
      new Cell[U] {
        override val max: Byte = m
        override val state: Byte = (s - 1).toByte
      }
    else
      this
  }

  /**
   *
   * @return
   */
  def minimize: Cell[U] = {
    val s = this.max
    val i = this.min
    new Cell[U] {
      override val state: Byte = i
      override val max: Byte = s
    }
  }

  /**
   *
   * @return
   */
  def maximize: Cell[U] = {
    val s = this.max
    new Cell[U] {
      override val state: Byte = s
      override val max: Byte = s
    }
  }

  override def toString: String = state.toString

}

/**
 * TODO: Doc
 * @param state
 */
case class Binary(state: Byte) extends Cell[Binary] { override val max: Byte = 1 }

/**
 * TODO: Doc
 * @param state
 */
case class Tertiary(state: Byte) extends Cell[Tertiary] { override val max: Byte = 2 }

/**
 * TODO: Doc
 * @param state
 * @param max
 */
case class nAry(state: Byte, max: Byte = Byte.MaxValue) extends Cell[nAry]




