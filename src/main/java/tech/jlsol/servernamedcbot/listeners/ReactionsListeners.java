package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
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
        //System.out.println(event.getReaction().retrieveUsers().complete().get(event.getReaction().retrieveUsers().complete().size()-1).getAsTag());
        Config.writeConfig("data", "reactionUser", event.getGuild().getId() + event.getChannel().getId() + event.getMessageId() + event.getReaction().getReactionEmote().getName(), Arrays.toString(event.getReaction().retrieveUsers().complete().toArray()));
        writeToFile(String.format("REACTION ADDED %s - %s - %s\n", Objects.requireNonNull(event.getReaction().getGuild()).getId(), event.getReaction().getChannel().getId(), emote));
        String[] emotes = new String[]{"RE:U+1f600", "RE:U+1f603", "RE:U+1f604", "RE:U+1f601", "RE:U+1f606", "RE:U+1f609",
                "RE:U+1f61d", "RE:U+1f60f", "RE:U+1f612", "RE:U+1f62b", "RE:U+2639U+fe0f", "RE:U+1f615", "RE:U+1f61f", "RE:U+1f9d0",
                "RE:U+1f617", "RE:U+1f619", "RE:U+1f929", "RE:U+1f61e", "RE:U+1f629", "RE:U+1f636"};
        List<String> list = Arrays.asList(emotes);

        if(list.contains(emote)) {
            System.out.printf("Emote: %s is member of list%n", emote);//738797819460190289
            if (event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("init"))) {// TODO: fix that
                ReactionHandler.controlReactionInitM(event, emote, getRole("interest"));
            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("politic"))){
                ReactionHandler.controlReactionPolitic(event, emote, getRole("interestPolitic"));
            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("games"))){
                ReactionHandler.controlReactionGames(event, emote, getRole("interestGames"));
            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("culture"))){
                ReactionHandler.controlReactionCulture(event, emote, getRole("interestCulture"));
            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("development"))){
                ReactionHandler.controlReactionDevelopment(event, emote, getRole("interestDevelopment"));
            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("creators"))){
                ReactionHandler.controlReactionCreators(event, emote, getRole("interestCreators"));
            }
        }
    }
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {
        String emote = event.getReaction().getReactionEmote().toString();
        Config.writeConfig("data", "reactionUser", event.getGuild().getId() + event.getChannel().getId() + event.getMessageId() + event.getReaction().getReactionEmote().getName(), Arrays.toString(event.getReaction().retrieveUsers().complete().toArray()));
        writeToFile(String.format("REACTION REMOVED %s - %s - %s\n", Objects.requireNonNull(event.getReaction().getGuild()).getId(), event.getReaction().getChannel().getId(), emote));
        String[] emotes = new String[]{"RE:U+1f600", "RE:U+1f603", "RE:U+1f604", "RE:U+1f601", "RE:U+1f606", "RE:U+1f609",
                "RE:U+1f61d", "RE:U+1f60f", "RE:U+1f612", "RE:U+1f62b", "RE:U+2639U+fe0f", "RE:U+1f615", "RE:U+1f61f", "RE:U+1f9d0",
                "RE:U+1f617", "RE:U+1f619", "RE:U+1f929", "RE:U+1f61e", "RE:U+1f629", "RE:U+1f636"};
        List<String> list = Arrays.asList(emotes);

        if(list.contains(emote)) {
            /*
            get message id
            test if user has reaction_role
            if yes
                remove
            do nothing
             */
            if (event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("init"))) {// TODO: fix that
                //ReactionHandler.controlReactionInitM(event, emote, getRole("interest"));
            }
//            else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("politic"))){
//
//            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("games"))){
//
//            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("culture"))){
//
//            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("development"))){
//
//            }else if(event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("creators"))){
//
//            }
        }
    }

    public static JSONObject getMsg(){
        File file = new File("./data/msg.json");
        String content;
        try {
            content = Files.readString(Path.of(file.toURI()));
            return new JSONObject(content).getJSONObject("messages");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject getRole(String object){
        File file = new File("./data/roles.json");
        String content;
        try {
            content = Files.readString(Path.of(file.toURI()));
            return new JSONObject(content).getJSONObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/*
Emote switch stuff: https://gist.github.com/johanneslosch/4f41bb4008ca4936c8595645e5005665
 */
