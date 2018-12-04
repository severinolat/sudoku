/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Arrays;

/**
 *
 * @author 128bits
 */
public class GrilleImpl implements Grille {
/**
*
* liste des charactères pouvant rentrer dans la grille.
*/
private char[] caracteresautoriser;
/**.
* Caractere de case vide
*./
static final char EMPTY = '@';
/**
* Caractere POSSIBLEc a mettre dans la grille
*
* pour une grille 9x9 : 1..9
*
* pour une grille 16x16: 0..9-a..f
*/
static final char[] POSSIBLE = new char[] {
'1', '2', '3', '4', '5', '6',
'7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f' };

/**.
* modele de grille pour controle
*/
private static char[][] gridtosolve = {
{'9', '0', '0', '1', '0', '0', '0', '0', '5'},
{'0', '0', '5', '0', '9', '0', '2', '0', '1'},
{'8', '0', '0', '0', '4', '0', '0', '0', '0'},
{'0', '0', '0', '0', '8', '0', '0', '0', '0'},
{'0', '0', '0', '7', '0', '0', '0', '0', '0'},
{'0', '0', '0', '0', '2', '6', '0', '0', '9'},
{'2', '0', '0', '3', '0', '0', '0', '0', '6'},
{'0', '0', '0', '2', '0', '0', '9', '0', '0'},
{'0', '0', '1', '9', '0', '4', '5', '7', '0'}, };
/**
* @param board grille
*/
private char[][] board;
/**
* @throw IllegalArgumentException si b == 0
* @param   grille  nouvelle grille
*/
 public GrilleImpl(final char[][] grille) {
        this.board = grille;
    }

 /**
     * The main method is where the rectangles are created.
     * @param   args  argument
     */
    public static void main(final String[] args) {
        // TODO code application logic here
        GrilleImpl grilleImpl = new GrilleImpl(gridtosolve);
     //   grilleImpl.display() ;
       boolean  valeurdimension = grilleImpl.POSSIBLEc(1, 2, '3');
        System.out.println(valeurdimension);
    }

/**.
* @return largeur/hauteur de la grille
*/
    @Override
    public int getDimension() {
        return this.board.length;
    }

/**.
* Affecte une valeur dans la grille
*
* @param x position x dans la grille
* @param y position y dans la grille
* @param value
* valeur a mettre dans la case
* @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
* @throw IllegalArgumentException si la valeur est interdite aux vues des
* autres valeurs de la grille
* @throw IllegalArgumentException si value n'est pas un caractere autorise
* ('1',...,'9')
*/
    @Override
    public void setValue(final int x, final int y, final char value)
    throws IllegalArgumentException {
  try {
      if ((0 < x) && (x < this.getDimension())  && (0 < y)
      && (y < this.getDimension())) {
        if (POSSIBLEc(x, y, value)) {
            this.board[x][y] = value;
        }
      }
      } catch (Exception e) {
            throw new IllegalArgumentException("indices ou valeur incorrectes");
      }
    }

/**.
* Recupere une valeur de la grille
*
* @param x position x dans la grille
* @param y position y dans la grille
* @return valeur dans la case x,y
* @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
*/
    @Override
    public char getValue(final int x, final int y)
    throws IllegalArgumentException {
        if ((0 < x) && (x < this.getDimension())
        && (0 < y) && (y < this.getDimension())) {
            return this.board[x][y];
        } else {
            throw new IllegalArgumentException(
            "indices incorrectes ou innexistant");
        }
    }

/**.
* Test si une grille est terminee
*
* @return true si la grille est complete
*/
    @Override
    public boolean complete() {
         return !Arrays.stream(this.board).anyMatch("@"::equals);
    }

/**.
* Caractere POSSIBLEc a mettre dans la grille
*
* pour une grille 9x9 : 1..9
*
* pour une grille 16x16: 0..9-a..f
*/
    @Override
    public boolean POSSIBLEc(final int x, final int y, final char value)
    throws IllegalArgumentException {
        caracteresautoriser = Arrays.copyOfRange(POSSIBLE,
         0, getDimension());
        int verif = 0;
        for (int k = 0; k < caracteresautoriser.length; k++) {
            if (caracteresautoriser[k] == value) {
    // do something
    verif = 1;
        break;
            }
        }
        if (verif == 0) {
            return false;
        }
        for (int i = 0; i < this.getDimension(); i++) {
if (this.board[x][i] == value) {
            return false;
    }
}
        for (int j = 0; j < this.getDimension(); j++) {
if (board[y][j] == value) {
      return false;
    }
    } return true;
    }
}
