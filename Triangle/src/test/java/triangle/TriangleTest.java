package triangle;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {

	final int TR_EQUILATERAL = 1; // ��������������
	final int TR_ISOSCELES = 2; // ��������������
	final int TR_ORDYNARY = 4; // �������
	final int TR_RECTANGULAR = 8; // �������������

	@DataProvider(name = "simpleDataProvider")
	public Object[][] createSomeData() {
		return new Object[][] { { "Ordynary triangle", new ArrayList<Double>(Arrays.asList(2.0, 3.0, 4.0)) },
				{ "Ordynary triangle", new ArrayList<Double>(Arrays.asList(3.0, 4.0, 2.0)) },
				{ "Ordynary triangle", new ArrayList<Double>(Arrays.asList(4.0, 2.0, 3.0)) } };
	}

	@DataProvider(name = "isoscelesTriangle")
	public Object[][] createDataForIsoscelesTriangle() {
		return new Object[][] { { "Isosceles Triangle", new ArrayList<Double>(Arrays.asList(3.0, 2.0, 3.0)) },
				{ "Isosceles Triangle", new ArrayList<Double>(Arrays.asList(3.0, 3.0, 2.0)) },
				{ "Isosceles Triangle", new ArrayList<Double>(Arrays.asList(2.0, 3.0, 3.0)) } };
	}

	@DataProvider(name = "equilateralTriangle")
	public Object[][] createDataForEquilateralTriangle() {
		return new Object[][] { { "Equilateral Triangle", new ArrayList<Double>(Arrays.asList(3.0, 3.0, 3.0)) } };
	}

	@DataProvider(name = "allZeroSides")
	public Object[][] createAllZeroSides() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0)) } };
	}

	@DataProvider(name = "rectangularTriangle")
	public Object[][] createDataForRectangularTriangle() {
		return new Object[][] { { "Rectangular Triangle", new ArrayList<Double>(Arrays.asList(4.0, 3.0, 5.0)) },
				{ "Rectangular Triangle", new ArrayList<Double>(Arrays.asList(5.0, 4.0, 3.0)) },
				{ "Rectangular Triangle", new ArrayList<Double>(Arrays.asList(3.0, 5.0, 4.0)) } };
	}

	@DataProvider(name = "wrongParametersForDetectMethod")
	public Object[][] createSideAPlusSideBIsEqualsToSideC() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)) },
				{ new ArrayList<Double>(Arrays.asList(2.0, 3.0, 1.0)) },
				{ new ArrayList<Double>(Arrays.asList(3.0, 1.0, 2.0)) } };
	}

	@DataProvider(name = "parametersAPlusParametersBLessThanParameterC")
	public Object[][] createParametersAPlusParametersBLessThanParameterC() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(4.0, 1.0, 2.0)) },
				{ new ArrayList<Double>(Arrays.asList(1.0, 2.0, 4.0)) },
				{ new ArrayList<Double>(Arrays.asList(2.0, 4.0, 1.0)) } };
	}

	@DataProvider(name = "doubleParameters")
	public Object[][] createDoubleParameters() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(6.3, 4.6, 7.8)) },
				{ new ArrayList<Double>(Arrays.asList(7.8, 6.3, 4.6)) },
				{ new ArrayList<Double>(Arrays.asList(4.6, 7.8, 6.3)) } };
	}

	@DataProvider(name = "zeroSide")
	public Object[][] createZeroSide() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(0.0, 1.0, 2.0)) },
				{ new ArrayList<Double>(Arrays.asList(2.0, 0.0, 1.0)) },
				{ new ArrayList<Double>(Arrays.asList(1.0, 2.0, 0.0)) } };
	}

	@DataProvider(name = "lessThanZeroSide")
	public Object[][] createLessThanZeroSide() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(-2.0, 1.0, 2.0)) },
				{ new ArrayList<Double>(Arrays.asList(1.0, 2.0, -2.0)) },
				{ new ArrayList<Double>(Arrays.asList(2.0, -2.0, 1.0)) } };
	}

	@DataProvider(name = "sideAIsLessThanOrEqualToZero")
	public Object[][] createSideAIsLessThanOrEqualToZero() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(-1.0, 2.0, 3.0)) },
				{ new ArrayList<Double>(Arrays.asList(0.0, 2.0, 3.0)) },
				{ new ArrayList<Double>(Arrays.asList(0.0, 2.0, 2.0)) } };
	}

	@DataProvider(name = "sideBIsLessThanOrEqualToZero")
	public Object[][] createSideBIsLessThanOrEqualToZero() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(2.0, -1.0, 3.0)) },
				{ new ArrayList<Double>(Arrays.asList(3.0, 0.0, 2.0)) },
				{ new ArrayList<Double>(Arrays.asList(2.0, 0.0, 2.0)) }, };
	}

	@DataProvider(name = "sideCIsLessThanOrEqualToZero")
	public Object[][] createSideCLessThanZero() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(3.0, 2.0, -1.0)) },
				{ new ArrayList<Double>(Arrays.asList(2.0, 2.0, 0.0)) },
				{ new ArrayList<Double>(Arrays.asList(3.0, 2.0, 0.0)) }, };
	}

	@DataProvider(name = "largeValues")
	public Object[][] createLargeValues() {
		return new Object[][] { { new ArrayList<Double>(Arrays.asList(1.7e308, 1.7e308, 1.7e308)) }, };
	}

	@Test
	public void testDetectOrdynaryTriangleWithDoubleParameters() {
		Triangle tr = new Triangle(4.2, 3.6, 2.2);
		int result = tr.detectTriangle();

		assertEquals(result, TR_ORDYNARY);
	}

	@Test(dataProvider = "simpleDataProvider")
	public void testSimple(String marker, ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertEquals(result, TR_ORDYNARY);
	}

	@Test(dataProvider = "isoscelesTriangle")
	public void testDetectIsoscelesTriangle(String marker, ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertEquals(result, TR_ISOSCELES);
	}

	@Test(dataProvider = "equilateralTriangle")
	public void testDetectEquilateralTriangle(String marker, ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertEquals(result, TR_EQUILATERAL);
	}

	@Test(dataProvider = "rectangularTriangle")
	public void testDetectRectangularTriangle(String marker, ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertEquals(result, TR_RECTANGULAR);
	}

	@Test(dataProvider = "doubleParameters")
	public void testDetectRectangularTriangleWithDoubleParameters(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertEquals(result, TR_RECTANGULAR);
	}

	@Test(dataProvider = "wrongParametersForDetectMethod")
	public void testThatTriangleDoesntExist(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertTrue((result != TR_ORDYNARY) || (result != TR_EQUILATERAL) || (result != TR_ISOSCELES)
				|| (result != TR_RECTANGULAR));
	}

	@Test(dataProvider = "parametersAPlusParametersBLessThanParameterC")
	public void testThatTriangleWhereSideAPlusSideBIsLessThanSideCDoesntExist(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertFalse((result == TR_ORDYNARY) || (result == TR_EQUILATERAL) || (result == TR_ISOSCELES)
				|| (result == TR_RECTANGULAR));
	}

	@Test(dataProvider = "zeroSide")
	public void testThatTriangleWithZeroSideDoesntExist(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertFalse((result == TR_ORDYNARY) || (result == TR_EQUILATERAL) || (result == TR_ISOSCELES)
				|| (result == TR_RECTANGULAR));
	}

	@Test(dataProvider = "allZeroSides")
	public void testThatTriangleWithAllZeroSidesDoesntExist(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertFalse((result == TR_ORDYNARY) || (result == TR_EQUILATERAL) || (result == TR_ISOSCELES)
				|| (result == TR_RECTANGULAR));
	}

	@Test(dataProvider = "lessThanZeroSide")
	public void testThatTriangleWithLessThanZeroSideDoesntExist(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertFalse((result == TR_ORDYNARY) || (result == TR_EQUILATERAL) || (result == TR_ISOSCELES)
				|| (result == TR_RECTANGULAR));
	}

	@Test(dataProvider = "parametersAPlusParametersBLessThanParameterC")
	public void testThatTriangleWhereSideAPlusSideBIsLessThanSideCDoesntExistByCheckTriangle(
			ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		boolean result = tr.checkTriangle();

		assertFalse(result);
	}

	@Test(dataProvider = "wrongParametersForDetectMethod")
	public void testThatTriangleWhereSideAPlusSideBIsEqualsToSideCDoesntExistByCheckTriangle(
			ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		boolean result = tr.checkTriangle();

		assertFalse(result);
	}

	@Test(dataProvider = "zeroSide")
	public void testThatTriangleWithZeroSideDoesntExistByCheckTriangle(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		boolean result = tr.checkTriangle();

		assertFalse(result);
	}

	@Test(dataProvider = "lessThanZeroSide")
	public void testThatTriangleWithLessThanZeroSideDoesntExistByCheckTriangle(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		boolean result = tr.checkTriangle();

		assertFalse(result);
	}

	@Test(dataProvider = "allZeroSides")
	public void testThatTriangleWithAllZeroSidesDoesntExist1ForCheckTriangle(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		boolean result = tr.checkTriangle();

		assertFalse(result);
	}

	@Test(dataProvider = "sideAIsLessThanOrEqualToZero")
	public void testMessageWhenSideAIsLessThanOrEqualToZero(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		tr.checkTriangle();
		String result = tr.getMessage();

		String expectedResult = "a<=0";
		assertEquals(result, expectedResult);
	}

	@Test(dataProvider = "sideBIsLessThanOrEqualToZero")
	public void testMessageWhenSideBIsLessThanOrEqualToZero(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		tr.checkTriangle();
		String result = tr.getMessage();

		String expectedResult = "b<=0";
		assertEquals(result, expectedResult);
	}

	@Test(dataProvider = "sideCIsLessThanOrEqualToZero")
	public void testMessageWhenSideCIsLessThanOrEqualToZero(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		tr.checkTriangle();
		String result = tr.getMessage();

		String expectedResult = "c<=0";
		assertEquals(result, expectedResult);
	}

	@Test(dataProvider = "largeValuesForEquilateralTr")
	public void testDetectEquilateralTriangleWithLargeValues(ArrayList<Double> parameters) {
		Double side_a = (Double) parameters.get(0);
		Double side_b = (Double) parameters.get(1);
		Double side_c = (Double) parameters.get(2);

		Triangle tr = new Triangle(side_a, side_b, side_c);
		int result = tr.detectTriangle();

		assertEquals(result, TR_EQUILATERAL);
	}
}
