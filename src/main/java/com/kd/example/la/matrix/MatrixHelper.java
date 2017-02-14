package com.kd.example.la.matrix;

import java.util.ArrayList;
import java.util.List;

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
		int nRows = A.getRowDimension();
		if (!A.isSquare()) {
			throw new Exception("Can not calculate determinent");
		}
		if (nRows == 2) {
			return getDetermenent2X2(A);
		} else {
			return getDetermenentNxN(A);
		}
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

	public static double getDetermenentNxN(RealMatrix A) {

		return 0;
	}

	public static RealMatrix getInverse(RealMatrix A) {
		return MatrixUtils.inverse(A);
	}
}
