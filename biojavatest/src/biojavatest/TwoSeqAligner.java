package biojavatest;

import edu.indiana.salsahpc.MatrixUtil;
import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.SimpleSubstitutionMatrix;
import org.biojava3.alignment.template.GapPenalty;
import org.biojava3.alignment.template.PairwiseSequenceAligner;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.compound.DNACompoundSet;
import org.biojava3.core.sequence.compound.NucleotideCompound;
import org.biojava3.core.sequence.template.Sequence;

import java.io.File;
import java.io.FileNotFoundException;

public class TwoSeqAligner {
    public static void main(String[] args) throws FileNotFoundException {
        DNASequence s1 = new DNASequence("CATCCAAGAGATAGTTGATCGTCTGAGAC");
        DNASequence s2 = new DNASequence("AGAGATGACTTAGTAGAACGTAGCGGAGTTTT");

        // Sequences that give different alignments w.r.t. this (old) MBF and BioJava update
//        DNASequence s1 = new DNASequence("CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACGCGGCGTCGCTCCATCAGGCTTGCGCCCATTGTGGAAGATTCCTAACTGCTGCCTCCCGTAGGAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCAACCAGCTGATGGAACGCAACCCCATCCAGAAGCGATAAATCTTTAGTGATGCACCACGGTGCATCACCACATCACGTATTAGCGGACCTTTCGGCCAGTTATTCGTGACTTCTGGGTAGGTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCAAGGCACACAGGGGA");
//        DNASequence s2 = new DNASequence("CTTCACCCCAATCATCCATCCCACCTTAGGCGGCTGGCCCCTAAAAGGTTACCTCACCGACTTCGGGTGTTACAAACTCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCCTCCAATCCGAACTGAGATCGGCTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGCACGTGTGTAGCCCAGGTCATAAGGGGCATGATGATTTGACGTCATCCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCGGGACTTAACCCAACATCTCACGACACGAGCTGACGACAACCATGCACCACCTGTCTCCGATGTACCGAAGTAACTTCCTATCTCTAAGAATAGCATCGGGATGTCAAGACCT");


//        DNASequence s1 = new DNASequence("AACTCTTGACATCCAGAGAAGAGGCTAGAGATAGCTTTGTGCCTTCGGATCGTCTGAGAC");
//        DNASequence s1 = new DNASequence("TGGTCTTGACATAGAAAGAACTTTCACGAGATGGATTGGTTGGCCTCGCTTGTCAGGAGGCTTCTTATCAG");

//        DNASequence s2 = new DNASequence("AGCACTTGACATACAACGAATTCGTCAGAGATGACTTAGTGCTACTTCGGTAGAACGTTGATACA");
//        DNASequence s2 = new DNASequence("AACTCTTGACATCCAGAGAAGAGGCTAGAGATAGCTTTTGTGCCTTCGGACGTCTGAGAC");

        SubstitutionMatrix<NucleotideCompound> matrix = MatrixUtil.getEDNAFULL();

        short gapOpen = 16;
        short gapExt = 4;
        GapPenalty penalty = new SimpleGapPenalty(gapOpen, gapExt);

        SequencePair<DNASequence,NucleotideCompound> pair =
                Alignments.getPairwiseAlignment(s1, s2, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, matrix);
        
        PairwiseSequenceAligner<DNASequence,NucleotideCompound> aligner = Alignments.getPairwiseAligner(s1, s2, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, matrix);
        System.out.println(aligner.getScore());
        System.out.println(aligner.getMaxScore());
        System.out.println(aligner.getMinScore());



        System.out.println(pair.getAlignedSequence(s1));
        System.out.println();
        System.out.println(pair.getAlignedSequence(s2));
        System.out.println();

//        pair = Alignments.getPairwiseAlignment(s2, s1, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, matrix);
//        System.out.println(pair.getAlignedSequence(s1));
//        System.out.println();
//        System.out.println(pair.getAlignedSequence(s2));


        /*
        Output from old MBF
        aS1: CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACG-CG-GCGT----CGCTCCATCAGGC--TTG-CGCC-CATTGTGGA---AGATTCCTA---ACTGCTGCCTCC-CGTAG-GAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCA-ACCAGCTGATG-GAACGCAACCCCATCCAGAAGCGATAA-ATCTTTAGTGATGCACCACGGTGCATCACCACA-T-CAC-GTATTAGCGGACCTTTCGGCCAGTTATTCGT-G--ACT-TC--T--GGGTAG-GTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCA--AGGCA--CACAGGGGA
        aS2: CTTCACCCCAATCATCC----ATCCCACCTTAGG--CGGC-TGGCCCCTAA-AAGGTTACCTCACCGACTTCGGGTGTTAC-AAAC--TCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCC---TCCAATCCGAACTGAGATCGG---CTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGCACGTGTGTAGCCCAGGTCAT-AAGGGGCATGATGATTTGACGTCAT-CCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCG-GG-ACTTAACCCAACATCTCAC-G--ACACGA--GCTGACGACAACCATG----CACCAC-CTGTCTCCGATGTACC-GAAGTAACTTCCTA-TCTCTAAGAATAGCATCGGGATGTCA-AGACCT
        */

        /*
        Output from New MBF
        aS1: CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACG-CG-GCGT----CGCTCCATCAGGC--TTG-CGCC-CATTGTGGA---AGATTCCTA---ACTGCTGCCTCC-CGTAG-GAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCA-ACCAGCTGATG-GAACGCAACCCCATCCAGAAGCGATAA-ATCTTTAGTGATGCACCACGGTGCATCACCACA-T-CAC-GTATTAGCGGACCTTTCGGCCAGTTATTCGT-G--ACT-TC--T--GGGTAG-GTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCA--AGGCA--CACAGGGGA
        aS2: CTTCACCCCAATCATCC----ATCCCACCTTAGG--CGGC-TGGCCCCTAA-AAGGTTACCTCACCGACTTCGGGTGTTAC-AAAC--TCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCC---TCCAATCCGAACTGAGATCGG---CTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGCACGTGTGTAGCCCAGGTCAT-AAGGGGCATGATGATTTGACGTCAT-CCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCG-GG-ACTTAACCCAACATCTCAC-G--ACACGA--GCTGACGACAACCATG----CACCAC-CTGTCTCCGATGTACC-GAAGTAACTTCCTA-TCTCTAAGAATAGCATCGGGATGTCA-AGACCT
         */

        /*
        Output from BioJava update
        aS1: CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACG-CG-GCGT----CGCTCCATCAGGC--TTG-CGCC-CATTGTGGA---AGATTCCTA---ACTGCTGCCTCC-CGTAG-GAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCAACCAGCTGATGGAACGCAACCCCATCCAGAAGCGATAAATCTTTAGTGATGCACCACGGTGCATCACCACATCACGTATTAGCGGACCTTTCGGCCAGTTATTCGTGACTT-CTG--GGTAGGTCA-GTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACC-CTG-AGCC-AGGATCAAAC--TCTCTGAGACTTCCA--AGGCA--CACAGGGGA
        aS2: CTTCACCCCAATCATCC----ATCCCACCTTAGG--CGGC-TGGCCCCTAA-AAGGTTACCTCACCGACTTCGGGTGTTAC-AAAC--TCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCC---TCCAATCCGAACTGAGATCGG---CTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGC-ACGTG-TGTAGCCCAGGTCATAAGGGGCATGATGATT-TGACGTCATCCCC-ACCTT-CCTCCGGT-TTATTACCCGGCAGTCTCGCTAG-AGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGC-TCGTTGCGGGACT-TAACCCAACATCTCACGACACGAGC-TGACGACAACCATGCACCACCTGTCTCCGATGTACCGAAGTAACTTCCTATCTCTAAGAATAGCATCGGGATGTCA-AGACCT
         */

        /*
        Output from SalsaNW
        aS1: CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACG-CG-GCGT----CGCTCCATCAGGC--TTG-CGCC-CATTGTGGA---AGATTCCTA---ACTGCTGCCTCC-CGTAG-GAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCA-ACCAGCTGATG-GAACGCAACCCCATCCAGAAGCGATAA-ATCTTTAGTGATGCACCACGGTGCATCACCACA-T-CAC-GTATTAGCGGACCTTTCGGCCAGTTATTCGT-G--ACT-TC--T--GGGTAG-GTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCA--AGGCA--CACAGGGGA
        aS2: CTTCACCCCAATCATCC----ATCCCACCTTAGG--CGGC-TGGCCCCTAA-AAGGTTACCTCACCGACTTCGGGTGTTAC-AAAC--TCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCC---TCCAATCCGAACTGAGATCGG---CTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGCACGTGTGTAGCCCAGGTCAT-AAGGGGCATGATGATTTGACGTCAT-CCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCG-GG-ACTTAACCCAACATCTCAC-G--ACACGA--GCTGACGACAACCATG----CACCAC-CTGTCTCCGATGTACC-GAAGTAACTTCCTA-TCTCTAAGAATAGCATCGGGATGTCA-AGACCT
         */


    }
    
}
