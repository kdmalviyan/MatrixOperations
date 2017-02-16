package com.kd.example.la.matrix;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class MatrixHelper {
	static List<Double> values = new ArrayList<>();

	public static RealMatrix getTranspose(RealMatrix A) {
		int nRows = A.getRowDimension();
		int nCol = A.getColumnDimension();
		RealMatrix matrix = MatrixUtils.createRealMatrix(nCol, nRows);
		for (int c = 0; c < nCol; c++) {
			for (int r = 0; r < nRows; r++) {
				matrix.addToEntry(c, r, A.getEntry(r, c));
			}
		}
		return matrix;
	}

	public static double getDetermenent(RealMatrix A) throws Exception {
		if (!A.isSquare()) {
			throw new Exception("Can not calculate determinent");
		}
		LUDecomposition decomposition = new LUDecomposition(A);
		return decomposition.getDeterminant();
	}

	public static double getDetermenent2X2(RealMatrix A) {
		return A.getEntry(0, 0) * A.getEntry(1, 1) - A.getEntry(0, 1) * A.getEntry(1, 0);
	}

	public static RealMatrix getSubMatrix(RealMatrix A, int startRow, int endRow, int startColumn, int endColumn) {
		RealMatrix subMatrix = MatrixUtils.createRealMatrix(endRow, endColumn);
		for (int i = 0; i < endRow; i++) {
			for (int j = 0; j < endRow; j++) {
				subMatrix.addToEntry(i, j, A.getEntry(startRow + i, startColumn + j));
			}
		}
		return subMatrix;
	}

	public static RealMatrix getInverse(RealMatrix A) {
		return MatrixUtils.inverse(A);
	}

	public static RealMatrix getAdjoint(RealMatrix A) throws OutOfRangeException, Exception {
		RealMatrix cofactorMatrix = getCoFactorMatrix(A);
		RealMatrix adjointMatrix = getTranspose(cofactorMatrix);
		return adjointMatrix;
	}

	/**
	 * TODO
	 * 
	 * @param A
	 * @return
	 * @throws Exception
	 * @throws OutOfRangeException
	 */
	public static RealMatrix getCoFactorMatrix(RealMatrix A) throws OutOfRangeException, Exception {
		int rNums = A.getRowDimension();
		int cNums = A.getColumnDimension();
		RealMatrix coFactorMatrix = MatrixUtils.createRealMatrix(rNums, cNums);
		for (int r = 0; r < rNums; r++) {
			for (int c = 0; c < cNums; c++) {
				RealMatrix subMatrix = getSubMatrix(A, r, c);
				coFactorMatrix.addToEntry(r, c, Math.pow(-1, (r + c)) * getDetermenent(subMatrix));
			}
		}
		return coFactorMatrix;
	}

	/**
	 * 
	 * @param A
	 * @param rowIndex
	 * @return
	 */
	public static RealMatrix getSubMatrix(RealMatrix A, int rowIndex, int colIndex) {
		int selectedRows[] = getRowIndexes(A.getRowDimension(), rowIndex);
		int selectedColumns[] = getColumnIndexes(A.getColumnDimension(), colIndex);
		return A.getSubMatrix(selectedRows, selectedColumns);
	}

	private static int[] getColumnIndexes(int columnDimension, int colIndex) {
		List<Integer> selectedCols = new ArrayList<>();
		for (int i = 0; i < columnDimension; i++) {
			if (i != colIndex) {
				selectedCols.add(i);
			}
		}
		return selectedCols.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int[] getRowIndexes(int rowDimension, int rowIndex) {
		List<Integer> selectedRows = new ArrayList<>();
		for (int i = 0; i < rowDimension; i++) {
			if (i != rowIndex) {
				selectedRows.add(i);
			}
		}
		return selectedRows.stream().mapToInt(Integer::intValue).toArray();
	}

}
