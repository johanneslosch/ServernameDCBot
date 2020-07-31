package tech.jlsol.servernamedcbot.listeners.util;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;


import static tech.jlsol.servernamedcbot.listeners.util.RoleManager.giveRole;

public class ReactionHandler {
    public static void controlReactionInitM(GuildMessageReactionAddEvent event, String emote){
        switch (emote) {
            case "RE:U+1f600": {//grinning
                giveRole(event, "role");
                break;
            }
            case "RE:U+1f603": {//SMILING FACE WITH OPEN MOUTH
                giveRole(event, "");
                break;//smiley
            }
            case "RE:U+1f604": {//SMILING FACE WITH OPEN MOUTH AND SMILING EYES
                break;//smiley
            }
            case "RE:U+1f601": {//GRINNING FACE WITH SMILING EYES
                break;
            }
            case "RE:U+1f606": {//SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
                break;
            }
            case "RE:U+1f609": {// 	WINKING FACE
                break;
            }
            case "RE:U+1f61d": {//FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
                break;
            }
            case "RE:U+1f60f": {//smirk
                break;
            }
            case "RE:U+1f612": {//UNAMUSED FACE
                break;
            }
            case "RE:U+1f62b": {//TIRED
                break;
            }
            case "RE:U+2639U+fe0f": {
                break;
            }
            case "RE:U+1f615": {//CONFUSED
                break;
            }
            case "RE:U+1f61f": {//WORRIED
                break;
            }
            case "RE:U+1f9d0": {//FACE WITH MONOCLE
                break;
            }
            case "RE:U+1f617": {//KISSING FACE
                break;
            }
            case "RE:U+1f619": {//KISSING FACE WITH SMILING EYES
                break;
            }
            case "RE:U+1f929": {//GRINNING FACE WITH STAR EYES
                break;
            }
            case "RE:U+1f61e": {//DISAPPOINTED
                break;
            }
            case "RE:U+1f629": {//WEARY FACE
                break;
            }
            case "RE:U+1f636": {//FACE WITHOUT MOUTH
                break;
            }

        }

    }

}
