package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.jlsol.servernamedcbot.listeners.util.ReactionHandler;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.Logger;
import tech.jlsol.servernamedcbot.util.WriteFile;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReactionsListeners extends ListenerAdapter {
    private void writeToFile(String content){
        WriteFile.writer("data", "msg", "txt", content);
    }

    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        String emote = event.getReaction().getReactionEmote().toString();
        /*
        "RE:U+1f600", "RE:U+1f603", "RE:U+1f604", "RE:U+1f601", "RE:U+1f606", "RE:U+1f609", "RE:U+1f61d", "RE:U+1f60f", "RE:U+1f612", "RE:U+1f62b", "RE:U+2639U+fe0f", "RE:U+1f615", "RE:U+1f61f", "RE:U+1f9d0", "RE:U+1f617", "RE:U+1f619", "RE:U+1f929", "RE:U+1f61e", "RE:U+1f629", "RE:U+1f636"
         */
        //System.out.println(event.getReaction().retrieveUsers().complete().get(event.getReaction().retrieveUsers().complete().size()-1).getAsTag());
        Config.writeConfig("data", "reactionUser", event.getGuild().getId() + event.getChannel().getId() + event.getMessageId() + event.getReaction().getReactionEmote().getName(), Arrays.toString(event.getReaction().retrieveUsers().complete().toArray()));
        writeToFile(String.format("REACTION ADDED %s - %s - %s\n", Objects.requireNonNull(event.getReaction().getGuild()).getId(), event.getReaction().getChannel().getId(), emote));
        String[] emotes = new String[]{"RE:U+1f600", "RE:U+1f603",
                "RE:U+1f604", "RE:U+1f601", "RE:U+1f606", "RE:U+1f609",
                "RE:U+1f61d", "RE:U+1f60f", "RE:U+1f612", "RE:U+1f62b",
                "RE:U+2639U+fe0f", "RE:U+1f615", "RE:U+1f61f", "RE:U+1f9d0",
                "RE:U+1f617", "RE:U+1f619", "RE:U+1f929", "RE:U+1f61e",
                "RE:U+1f629", "RE:U+1f636"};
        List<String> list = Arrays.asList(emotes);

        if(list.contains(emote)) {
            System.out.printf("Emote: %s is member of list%n", emote);//738797819460190289
//            if(event.getChannel().getIdLong() == id){//Config.readConfig("data", "messages", "messageGeneralRoles") TODO: fix that
                switch (emote) {
                    case "RE:U+1f600": {//grinning
                        giveRole(event, "dfg");
                        break;
                    }
                    case "RE:U+1f603": {//SMILING FACE WITH OPEN MOUTH
                        giveRole(event, "talk");
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
    //}
    public boolean hasRole(GuildMessageReactionAddEvent event, Role role){
        return event.getMember().getRoles().contains(role);
    }
    public void giveRole(GuildMessageReactionAddEvent event, String role){
        if(!hasRole(event, event.getGuild().getRolesByName(role, true).get(0))){
            event.getGuild().addRoleToMember(event.getUserId(), event.getGuild().getRolesByName(role, true).get(0)).reason("reacted to Message").queue();
            Logger.warning(String.format("User %s got role %s", event.getUserId(), role));
        }
    }
    public static void getRole(){
        File file = new File("./data/roles.json");
        String content = null;
        try {
            //content = Files.readString(Path.of(file.toURI()));
            content = Files.readString(Path.of("./data/roles.json"));
            JSONObject jsonObject = new JSONObject(content).getJSONArray("interest").getJSONObject(0);//.getJSONObject("politic");
            System.out.println( );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        getRole();
    }
}
/*
Emote switch stuff: https://gist.github.com/johanneslosch/4f41bb4008ca4936c8595645e5005665
 */
