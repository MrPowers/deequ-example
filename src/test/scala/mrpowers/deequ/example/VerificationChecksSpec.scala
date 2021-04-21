package mrpowers.deequ.example

import org.scalatest.FunSpec
import com.amazon.deequ.VerificationSuite
import com.amazon.deequ.checks.{Check, CheckLevel, CheckStatus}

class VerificationChecksSpec extends FunSpec with SparkSessionTestWrapper {

  import spark.implicits._

  describe("isUnique") {
    it("checks to make sure a column is unique") {
      val df = Seq(
        (1, "bob"),
        (2, "thiago"),
        (3, "lilly")
      ).toDF("person_id", "person_name")
      val verificationResult = VerificationSuite()
        .onData(df)
        .addCheck(
          Check(CheckLevel.Error, "unit testing my data")
            .isUnique("id"))
        .run()
    }
  }

}
