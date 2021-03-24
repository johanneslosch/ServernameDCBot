package tech.jlsol.servernamedcbot.listeners.util;

import static tech.jlsol.servernamedcbot.listeners.util.RoleManager.giveRole;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import org.json.JSONObject;

public class ReactionAddHandler {

  public static void controlReactionInitM(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("politic").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("games").toString());
          break; //smiley
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("art").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("science").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("creators").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("development").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("twitch").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("culture").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("notify").toString());
          break;
        }
      //unused emotes
      /*
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
            }*/
    }
  }

  public static void controlReactionGames(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("game1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("game2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("game3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("game4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("game5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("game6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("game7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("game8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("game9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("game10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("game11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("game12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("game13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("game14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("game15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("game16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("game17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("game18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("game19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("game20").toString());
          break;
        }
    }
  }

  public static void controlReactionArt(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("role1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("role2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("role3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("role4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("role6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("role8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("role9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("role10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("role11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("role12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("role13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("role14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("role15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("role16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("role17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("role18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("role19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("role20").toString());
          break;
        }
    }
  }

  public static void controlReactionScience(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("role1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("role2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("role3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("role4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("role6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("role8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("role9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("role10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("role11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("role12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("role13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("role14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("role15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("role16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("role17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("role18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("role19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("role20").toString());
          break;
        }
    }
  }

  public static void controlReactionCulture(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("role1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("role2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("role3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("role4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("role6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("role8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("role9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("role10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("role11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("role12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("role13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("role14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("role15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("role16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("role17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("role18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("role19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("role20").toString());
          break;
        }
    }
  }

  public static void controlReactionDevelopment(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("role1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("role2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("role3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("role4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("role6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("role8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("role9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("role10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("role11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("role12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("role13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("role14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("role15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("role16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("role17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("role18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("role19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("role20").toString());
          break;
        }
    }
  }

  public static void controlReactionPolitic(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("role1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("role2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("role3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("role4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("role6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("role8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("role9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("role10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("role11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("role12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("role13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("role14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("role15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("role16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("role17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("role18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("role19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("role20").toString());
          break;
        }
    }
  }

  public static void controlReactionCreators(
    GuildMessageReactionAddEvent event,
    String emote,
    JSONObject role
  ) {
    switch (emote) {
      case "RE:U+1f600":
        { //grinning
          giveRole(event, role.get("role1").toString());
          break;
        }
      case "RE:U+1f603":
        { //SMILING FACE WITH OPEN MOUTH
          giveRole(event, role.get("role2").toString());
          break; //smile
        }
      case "RE:U+1f604":
        { //SMILING FACE WITH OPEN MOUTH AND SMILING EYES
          giveRole(event, role.get("role3").toString());
          break; //smiley
        }
      case "RE:U+1f601":
        { //GRINNING FACE WITH SMILING EYES
          giveRole(event, role.get("role4").toString());
          break;
        }
      case "RE:U+1f606":
        { //SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role5").toString());
          break;
        }
      case "RE:U+1f609":
        { // 	WINKING FACE
          giveRole(event, role.get("role6").toString());
          break;
        }
      case "RE:U+1f61d":
        { //FACE WITH STUCK-OUT TONGUE AND TIGHTLY-CLOSED EYES
          giveRole(event, role.get("role7").toString());
          break;
        }
      case "RE:U+1f60f":
        { //smirk
          giveRole(event, role.get("role8").toString());
          break;
        }
      case "RE:U+1f612":
        { //UNAMUSED FACE
          giveRole(event, role.get("role9").toString());
          break;
        }
      case "RE:U+1f62b":
        { //TIRED
          giveRole(event, role.get("role10").toString());
          break;
        }
      case "RE:U+2639U+fe0f":
        {
          giveRole(event, role.get("role11").toString());
          break;
        }
      case "RE:U+1f615":
        { //CONFUSED
          giveRole(event, role.get("role12").toString());
          break;
        }
      case "RE:U+1f61f":
        { //WORRIED
          giveRole(event, role.get("role13").toString());
          break;
        }
      case "RE:U+1f9d0":
        { //FACE WITH MONOCLE
          giveRole(event, role.get("role14").toString());
          break;
        }
      case "RE:U+1f617":
        { //KISSING FACE
          giveRole(event, role.get("role15").toString());
          break;
        }
      case "RE:U+1f619":
        { //KISSING FACE WITH SMILING EYES
          giveRole(event, role.get("role16").toString());
          break;
        }
      case "RE:U+1f929":
        { //GRINNING FACE WITH STAR EYES
          giveRole(event, role.get("role17").toString());
          break;
        }
      case "RE:U+1f61e":
        { //DISAPPOINTED
          giveRole(event, role.get("role18").toString());
          break;
        }
      case "RE:U+1f629":
        { //WEARY FACE
          giveRole(event, role.get("role19").toString());
          break;
        }
      case "RE:U+1f636":
        { //FACE WITHOUT MOUTH
          giveRole(event, role.get("role20").toString());
          break;
        }
    }
  }
}
