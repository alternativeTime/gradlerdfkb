package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class LiteratureByID extends SelectSparqlBean implements GlycanGlycobase {

    public static final String LiteratureURI = "LiteratureURI";
    public static final String Title = "Title";
    public static final String Year = "Year";
    public static final String PeakArea = "PeakArea";
    public static final String MsVerificationURI = "MsVerificationURI";
    public static final String Ms1Verified = "Ms1Verified";
    public static final String Ms2Verified = "Ms2Verified";
    public static final String EnzymeVerified = "EnzymeVerified";

    public LiteratureByID(String sparql) {
        super(sparql);
    }

    public LiteratureByID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/> \n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n";;  //need to add # glycan#
        this.select = "DISTINCT ?" + ReferenceCompoundURI + " ?" + Title + " ?"+ Year
                + " ?"+ Gu2AB + " ?"+ GuProcainamide + " ?" + PeakArea + " ?" + Ms1Verified + " ?" + Ms2Verified  + "\n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:published_in ?" + LiteratureURI + " .\n"

                + "OPTIONAL{\n ?" + ReferenceCompoundURI + " glycan:has_evidence ?" + MsVerificationURI + " .\n"
                + "?" + MsVerificationURI + " glycan:ms1_verified ?" + Ms1Verified + " .\n}\n"
                + "OPTIONAL{\n ?" + ReferenceCompoundURI + " glycan:has_evidence ?" + MsVerificationURI + " .\n"
                + "?" + MsVerificationURI + " glycan:ms2_verified ?" + Ms2Verified + " .\n}\n"
                + "OPTIONAL{\n ?" + PeakURI + " glycan:has_peak_area ?" + PeakArea + " .\n}\n"

                + "?" + LiteratureURI + " dc:title ?" + Title + " ;\n"
                + " bibo:issued ?" + Year + " .\n"

                + "OPTIONAL{\n ?" + ProfileURI + " glycan:has_label " + "'Procainamide';\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI + " (glycan:has_glucose_unit|glycan:has_arabinose_unit) ?" + GuProcainamide + " .\n}\n"


                + "OPTIONAL{\n ?" + ProfileURI + " glycan:has_label " + "'2-AB';\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI + " (glycan:has_glucose_unit|glycan:has_arabinose_unit) ?" + Gu2AB + " .\n}\n";


        return where;
    }
}
