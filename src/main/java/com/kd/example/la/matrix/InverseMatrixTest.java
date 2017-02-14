package com.kd.example.la.matrix;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;;

public class InverseMatrixTest {
	public static void main(String[] args) throws Exception {
		transpose();
		determinent();
		double[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RealMatrix A = new Array2DRowRealMatrix(values);
		MatrixHelper.getDetermenent(A);
	}

	private static void determinent() throws Exception {
		double[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RealMatrix A = new Array2DRowRealMatrix(values);
		double S = MatrixHelper.getDetermenent(A);
		System.out.println(S);

	}

	private static void transpose() {
		double[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RealMatrix A = new Array2DRowRealMatrix(values);
		RealMatrix T = MatrixHelper.getTranspose(A);
		System.out.println(T);
	}
}
