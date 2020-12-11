import XCTest
@testable import PMGrep

final class PMGrepTests: XCTestCase {
    func testExample() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct
        // results.
        let pm = PikeMatcher()
        var result = pm.match(regexp: "abc", text: "defabc")
        XCTAssertEqual(result, true)
        result = pm.match(regexp: "abc", text: "def")
        XCTAssertEqual(result, false)
        result = pm.match(regexp: "^abc", text: "abc")
        XCTAssertEqual(result, true)
        result = pm.match(regexp: "abc$", text: "abc")
        XCTAssertEqual(result, true)
        result = pm.match(regexp: "^abc$", text: "abc")
        XCTAssertEqual(result, true)
        result = pm.match(regexp: "^a.c", text: "abc")
        XCTAssertEqual(result, true)
        result = pm.match(regexp: "^a..", text: "abcd")
        XCTAssertEqual(result, true)
    }

    static var allTests = [
        ("testExample", testExample),
    ]
}
