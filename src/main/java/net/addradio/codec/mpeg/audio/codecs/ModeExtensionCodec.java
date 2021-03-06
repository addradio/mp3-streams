/**
 * Class:    ModeExtensionCodec<br/>
 * <br/>
 * Created:  20.10.2017<br/>
 * Filename: ModeExtensionCodec.java<br/>
 * Version:  $Revision$<br/>
 * <br/>
 * last modified on $Date$<br/>
 *               by $Author$<br/>
 * <br/>
 * @author <a href="mailto:sebastian.weiss@nacamar.de">Sebastian A. Weiss, nacamar GmbH</a>
 * @version $Author$ -- $Revision$ -- $Date$
 * <br/>
 * (c) Sebastian A. Weiss, nacamar GmbH 2017 - All rights reserved.
 */
package net.addradio.codec.mpeg.audio.codecs;

import net.addradio.codec.mpeg.audio.model.MPEGAudioFrame;
import net.addradio.codec.mpeg.audio.model.ModeExtension;

/**
 * ModeExtensionCodec.
 */
public final class ModeExtensionCodec {

    /**
     * decode.
     * @param frame {@link MPEGAudioFrame}
     * @param value {@code int}
     * @return {@link ModeExtension}
     * @throws MPEGAudioCodecException if value could not be decoded.
     */
    public static final ModeExtension decode(final MPEGAudioFrame frame, final int value)
            throws MPEGAudioCodecException {
        switch (frame.getMode()) {
        case JointStereo:
            switch (frame.getLayer()) {
            case I:
            case II:
                switch (value) {
                case 0b00:
                    return ModeExtension.SubBands4To31;
                case 0b01:
                    return ModeExtension.SubBands8To31;
                case 0b10:
                    return ModeExtension.SubBands12To31;
                case 0b11:
                    return ModeExtension.SubBands16To31;
                default:
                    break;
                }
                break;
            case III:
                switch (value) {
                case 0b00:
                    return ModeExtension.IntensityStereo_Off__MSStereo_Off;
                case 0b01:
                    return ModeExtension.IntensityStereo_On__MSStereo_Off;
                case 0b10:
                    return ModeExtension.IntensityStereo_Off__MSStereo_On;
                case 0b11:
                    return ModeExtension.IntensityStereo_On__MSStereo_On;
                default:
                    break;
                }
                break;
            case reserved:
            default:
                break;
            }
            throw new MPEGAudioCodecException("Could not decode ModeExtension [valueToBeDecoded: " + value + "]."); //$NON-NLS-1$ //$NON-NLS-2$
        case DualChannel:
        case SingleChannel:
        case Stereo:
        default:
            break;
        }
        return null;
    }

    /**
     * encode.
     * @param frame {@link MPEGAudioFrame}
     * @return {@code int}
     * @throws MPEGAudioCodecException if model is ill-formed.
     */
    public static int encode(final MPEGAudioFrame frame) throws MPEGAudioCodecException {
        switch (frame.getMode()) {
        case JointStereo:
            switch (frame.getLayer()) {
            case I:
            case II:
                switch (frame.getModeExtension()) {
                case SubBands4To31:
                    return 0b00;
                case SubBands8To31:
                    return 0b01;
                case SubBands12To31:
                    return 0b10;
                case SubBands16To31:
                    return 0b11;
                //$CASES-OMITTED$
                default:
                    break;
                }
                break;
            case III:
                switch (frame.getModeExtension()) {
                case IntensityStereo_Off__MSStereo_Off:
                    return 0b00;
                case IntensityStereo_On__MSStereo_Off:
                    return 0b01;
                case IntensityStereo_Off__MSStereo_On:
                    return 0b10;
                case IntensityStereo_On__MSStereo_On:
                    return 0b11;
                //$CASES-OMITTED$
                default:
                    break;
                }
                break;
            case reserved:
            default:
                break;
            }
            throw new MPEGAudioCodecException("Could not encode ModeExtension [frame: " + frame + "]."); //$NON-NLS-1$ //$NON-NLS-2$
            //$FALL-THROUGH$
        case DualChannel:
        case SingleChannel:
        case Stereo:
        default:
            break;
        }
        return 0;
    }

}
