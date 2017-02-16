package com.kd.example.la.matrix;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;;

public class MatrixTestExamples {
	public static void main(String[] args) throws Exception {
		double[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RealMatrix A = new Array2DRowRealMatrix(values);
		System.out.println(MatrixHelper.getAdjoint(A));
	}
}
